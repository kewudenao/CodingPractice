package AboutExcel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author kewudenao 2022-04-16 15:42
 **/
public class ExcelDemo {
/**
	@ApiOperation(value = "采购导入模板")
	@GetMapping("/template/download")
	public ResponseData<?> buTemplateDownload(@PathVariable("organizationId") Long organizationId, HttpServletResponse response) {
		ResponseData<?> responseData = new ResponseData<>();
		try {
			hpsPurchaseImportTempService.plantTemplateDownload(organizationId, response);
		} catch (Exception ex) {
			responseData.setSuccess(false);
			responseData.setMessage(ex.getMessage());
		}
		return responseData;
	}

	@ApiOperation(value = "Excel模板数据导入")
	@PostMapping(value = "/plant/import", produces = "application/json;charset=UTF-8")
	public ResponseData<HpsPurchaseImportReturnDTO> purchaseImport(@PathVariable("organizationId") Long organizationId,
	                                                               @RequestPart(value = "file") MultipartFile file) {
		ResponseData<HpsPurchaseImportReturnDTO> responseData = new ResponseData<>();
		try {
			responseData.setRows(hpsPurchaseImportTempService.purchaseRequireImport(organizationId, file));
		} catch (Exception ex) {
			responseData.setSuccess(false);
			responseData.setMessage(ex.getMessage());
		}
		return responseData;
	}


	// 使用Excel 工具类需要导入org.apache.poi 包
	public void plantTemplateDownload(Long tenantId, HttpServletResponse response) {
		try(OutputStream outputStream = response.getOutputStream(); XSSFWorkbook workbook = new XSSFWorkbook()){
			XSSFSheet sheet = workbook.createSheet("当前Sheet页名称");
			XSSFRow titleRow = sheet.createRow(0);


			titleRow.setHeight((short) 260);

			// 样式 格子样式
			XSSFCellStyle cellStyle = workbook.createCellStyle();

			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
			cellStyle.setBorderBottom(BorderStyle.THIN);;
			cellStyle.setBorderLeft(BorderStyle.THIN);;
			cellStyle.setBorderRight(BorderStyle.THIN);;
			cellStyle.setBorderTop(BorderStyle.THIN);;

			// 字体
			XSSFFont font = workbook.createFont();
			font.setFontName("微软雅黑");
			font.setFontHeightInPoints((short)10);
			cellStyle.setFont(font);

			// 样式2
			XSSFCellStyle cellStyle2 = workbook.createCellStyle();
			cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellStyle2.setAlignment(HorizontalAlignment.CENTER);
			cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
			cellStyle2.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
			cellStyle2.setFont(font);
			cellStyle2.setBorderBottom(BorderStyle.THIN);
			cellStyle2.setBorderLeft(BorderStyle.THIN);
			cellStyle2.setBorderRight(BorderStyle.THIN);
			cellStyle2.setBorderTop(BorderStyle.THIN);


			Map<Integer,String> columnMap = new LinkedHashMap<>();
			// 设置列
			setExcelTitleContent(columnMap);
			XSSFDrawing drawingPatriarch = sheet.createDrawingPatriarch();

			for(int i =0; i<columnMap.size();i++){
				XSSFCell cell = titleRow.createCell(i);
				if(4>=i){
					cell.setCellStyle(cellStyle2); // 设不同列样式
				}else {

					cell.setCellStyle(cellStyle);
				}
				cell.setCellValue(columnMap.get(i));
				sheet.setColumnWidth(i, 5000);  //设置行高
				if(5==i){
					continue;
				}
				// 设置 excel注释
				XSSFComment comment = drawingPatriarch.createCellComment(new XSSFClientAnchor(0, 0, 0, 0, (short) 4, 3, (short) 6, 6));
				if(0==i){
					comment.setString("1.必填；\n"+
							"2.输入采购需求所属的站点的ID");
				}else if(1==i){
					comment.setString("1.必填；\n"+
							"2.采购站点所对应的采购区域id");
				}else if(2==i){
					comment.setString("1.必填；\n"+
							"2.采购站点下的物料ID");
				}else if(3==i){
					comment.setString("1.必填；\n"+
							"2.输入数值，需保留小数点后六位");
				}else if(4==i){
					comment.setString("1.必填；\n"+
							"2.格式:YYYY-MM-DD");
				}
				comment.setAuthor("Microsoft Office User:");
				cell.setCellComment(comment);
			}

			//设置列样式
			XSSFCellStyle columnStyle = workbook.createCellStyle();
			XSSFDataFormat format = workbook.createDataFormat();
			// 设置列格式统一为文本格式
			columnStyle.setDataFormat(format.getFormat("@"));
			for(int i = 0;i<columnMap.size();i++){
				sheet.setDefaultColumnStyle(i, columnStyle);
			}

			response.setHeader("Content-disposition",
					"attachment; filename=\"" + URLEncoder.encode("采购需求导入模板.xlsx", "UTF-8") + "\"");
			response.setHeader("Access-Control-Expose-Headers", "Content-disposition");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			workbook.write(outputStream);


		} catch (IOException e) {
			LogUtils.debug(e.getMessage());
			throw new MtException("采购需求导入模板" + e.getMessage());
		}
	}


	// 从Excel读数据的逻辑：把每一行都当做字符串读取 存储到中间表中，另外开发一个校验的接口，将校验的数据放入对应的字段

	@Transactional(rollbackFor = Exception.class)
	public HpsPurchaseImportReturnDTO purchaseRequireImport(Long organizationId, MultipartFile file) {
		String apiName = "purchaseRequireImport";
		InputStream in;
		try {
			in = file.getInputStream();
		} catch (IOException e) {
			// 抛出便于用户理解的异常
		}
		Workbook workbook;
		try {
			workbook = ImportExeclUtil.chooseWorkbook(Objects.requireNonNull(file.getOriginalFilename()), in);
		} catch (IOException e) {
			// 抛出便于用户理解的异常
		}

		Sheet sheet = workbook.getSheetAt(0);
		// 获取总行数
		int rowNumber = sheet.getPhysicalNumberOfRows();
		if(rowNumber<2){
			// 抛出便于用户理解的异常
		}
		List<HpsPurchaseImportTemp> importData = new ArrayList<>();
		UUID uuid = UUID.randomUUID();
		String batchId = uuid.toString();
		int i = 1;
		List<String> numberList = getNumberList(organizationId, Long.valueOf(rowNumber - 1));
		List<Long> nextPrimaryKeys = mtCustomDbRepository.getNextPrimaryKeys(HpsPurchaseImportTemp.class, rowNumber - 1);
		List<Long> nextCids = mtCustomDbRepository.getNextCids(HpsPurchaseImportTemp.class, rowNumber - 1);
		for (int j=0;j<rowNumber-1;j++) {
			Row row = sheet.getRow(i++);
			HpsPurchaseImportTemp hpsPurchaseImportTemp = new HpsPurchaseImportTemp();
			getValueFromExcel(row,hpsPurchaseImportTemp,organizationId);
			hpsPurchaseImportTemp.setTenantId(organizationId);
			hpsPurchaseImportTemp.setBatchId(batchId);
			hpsPurchaseImportTemp.setImportTempId(nextPrimaryKeys.get(j));
			hpsPurchaseImportTemp.setCid(nextCids.get(j));
			hpsPurchaseImportTemp.setImportNum(numberList.get(j));
			importData.add(hpsPurchaseImportTemp);
		}

		mtCustomDbRepository.batchInsertWithPrimaryKey(importData);
		HpsPurchaseImportReturnDTO returnDTO = new HpsPurchaseImportReturnDTO();
		returnDTO.setBatchId(batchId);
		return returnDTO;
	}


	private void  getValueFromExcel(Row row,HpsPurchaseImportTemp hpsPurchaseImportTemp,Long tenanId){
		Map<Integer,String> valueMap = new HashMap<>(16);
		try {
			for(int i =0;i<6;i++){
				Cell cell = row.getCell(i);
				valueMap.put(i,ObjectUtils.isEmpty(cell)?"":cell.getStringCellValue());

			}
		} catch (Exception e) {
			 //根据定义抛出想要的异常更容易让用户理解
		}
		// 将值设置在中间表中
		hpsPurchaseImportTemp.setPurchaseSiteCode(valueMap.get(0).trim());
		hpsPurchaseImportTemp.setAreaCode(valueMap.get(1).trim());
		hpsPurchaseImportTemp.setMaterialCode(valueMap.get(2).trim());
		hpsPurchaseImportTemp.setDemandQtyStr(valueMap.get(3).trim());
		hpsPurchaseImportTemp.setDemandDateStr(valueMap.get(4).trim());
		hpsPurchaseImportTemp.setRemark(valueMap.get(5).trim());
		hpsPurchaseImportTemp.setDemandStatus("NEW");
	}
	**/
}

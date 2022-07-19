package src;

/**
 * @author kewudenao 2022-04-23 21:45
 **/
public class Mapper {
	/**
	 *   Mapper 文件 多条件in的写法
	 *   需要注意的问题 ： Oracle中in条件超过1000个会报错 所以要分批查询
	<select id="selectByMoIdAndMaterialId" resultMap="BaseResultMap" >
	select t.MO_ASS_ACTUAL_ID,t.MATERIAL_ID,t.ASSEMBLE_QTY,t.MO_ID
	from mt_mo_ass_actual t
	WHERE t.tenant_id = #{tenantId}
	And (t.MO_ID,t.MATERIAL_ID) in
        <foreach collection="list"  item="item" open="(" close=")" separator=",">
			(#{item.moId},#{item.materialId})
        </foreach>
    </select>

	 List<MoAssActual> selectByMoIdAndMaterialId(@Param("tenantId") Long tenantId,
	 @Param("list") List<HpsMtMoAssActualQueryVo> list);


	 public List<MoAssActual> selectByMoIdAndMaterialId(Long tenantId, List<HpsMtMoAssActualQueryVo> list){
	 if(CollectionUtils.isEmpty(list)){
	 return null;
	 }
	 List<MoAssActual> moAssActuals = new ArrayList<>(list.size());
	 int valueSize = list.size();
	 if (valueSize==1){
	 moAssActuals = moAssActualMapper.selectByMoIdAndMaterialId(tenantId, list);
	 }else {
	 int batchSize = valueSize/MaxInSize+(valueSize % MaxInSize == 0 ? 0 : 1);
	 for (int i = 0; i < batchSize; i++) {
	 // 获取list中 最多1000条数据
	 List<HpsMtMoAssActualQueryVo> queryVoList = list.stream()
	 .skip(i*MaxInSize).limit(MaxInSize).collect(Collectors.toList());
	 List<MoAssActual> resultList = moAssActualMapper.selectByMoIdAndMaterialId(tenantId, queryVoList);
	 moAssActuals.addAll(resultList);
	 }
	 }
	 return moAssActuals;
	 **/

}

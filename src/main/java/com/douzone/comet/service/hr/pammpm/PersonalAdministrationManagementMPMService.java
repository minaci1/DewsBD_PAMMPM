package com.douzone.comet.service.hr.pammpm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.codehaus.jettison.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.cryptography.enums.EncryptStyle;
import com.douzone.comet.service.hr.pammpm.dao.Pammpm00200_Dao;
import com.douzone.comet.service.hr.pammpm.models.Pammpm00200_Model;
import com.douzone.comet.service.util.BlackBoxUtil;
import com.douzone.comet.service.util.api.models.EncParameter;
import com.douzone.comet.service.util.mybatis.MyBatisUtil;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import com.douzone.gpd.jdbc.core.MapperType;
import com.douzone.gpd.jdbc.objects.SqlPack;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;

/**
 * @description :
 * @Since :
 * @Author :
 * @History :
 */
@DzApiService(value = "PersonalAdministrationManagementMPMService", module = CometModule.HR, desc = "공통코드")
public class PersonalAdministrationManagementMPMService extends DzCometService {

	@Autowired
	Pammpm00200_Dao dao;

	@DzApi(url = "/pammpm00200_InsuValDc", desc = "사업장관리번호-조회", httpMethod = DzRequestMethod.GET)
	public List<Map<String, Object>> pammpm00200_InsuValDc(
			@DzParam(key = "bizarea_cd", desc = "사업장코드", paramType = DzParamType.QueryString) String bizarea_cd)
			throws Exception {

		try {

			HashMap<String, Object> parameters = new HashMap<String, Object>();

			// mapper id 접근
			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pammpm00200_Dao.pammpm00200_InsuValDc");

			parameters.put("P_BIZAREA_CD", bizarea_cd);
			parameters.put("P_COMPANY_CD", this.getCompanyCode());

			System.out.println("parameters" + parameters);

			SqlPack so = new SqlPack();

			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.getInParameters().putAll(parameters);
			so.setSqlText(sqlText);

			List<Map<String, Object>> checkSdtl = this.queryForList(so);

			System.out.println("이 값은 " + checkSdtl);
			return checkSdtl;

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}

	@DzApi(url = "/pammpm00200_BizareaInfo", desc = "사업장정보-조회", httpMethod = DzRequestMethod.GET)
	public List<Map<String, Object>> pammpm00200_BizareaInfo(
			@DzParam(key = "bizarea_cd", desc = "사업장코드", paramType = DzParamType.QueryString) String bizarea_cd)
			throws Exception {

		try {

			HashMap<String, Object> parameters = new HashMap<String, Object>();

			// mapper id 접근
			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pammpm00200_Dao.pammpm00200_BizareaInfo");

			parameters.put("P_BIZAREA_CD", bizarea_cd);
			parameters.put("P_COMPANY_CD", this.getCompanyCode());

			System.out.println("parameters" + parameters);

			SqlPack so = new SqlPack();

			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.getInParameters().putAll(parameters);
			so.setSqlText(sqlText);
	 
			List<Map<String, Object>> checkSdtl = this.queryForList(so);

			System.out.println("이 값은 " + checkSdtl);
			return checkSdtl;

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}

	@DzApi(url = "/pammpm00200_CharCdValDc", desc = "우선지원대상기업-조회", httpMethod = DzRequestMethod.GET)
	public List<Map<String, Object>> pammpm00200_CharCdValDc() throws Exception {

		try {

			HashMap<String, Object> parameters = new HashMap<String, Object>();

			// mapper id 접근
			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pammpm00200_Dao.pammpm00200_CharCdValDc");

			SqlPack so = new SqlPack();

			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.getInParameters().putAll(parameters);
			so.setSqlText(sqlText);

			List<Map<String, Object>> checkSdtl = this.queryForList(so);
			System.out.println("이 값은 " + checkSdtl);
			return checkSdtl;

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}

	@DzApi(url = "/pammpm00200_LoginMemberInfo", desc = "로그인유저정보", httpMethod = DzRequestMethod.GET)
	public List<Map<String, Object>> pammpm00200_LoginMemberInfo(
			@DzParam(key = "emp_no", desc = "사원번호", paramType = DzParamType.QueryString) String emp_no)
			throws Exception {

		try {

			HashMap<String, Object> parameters = new HashMap<String, Object>();

			// mapper id 접근
			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pammpm00200_Dao.pammpm00200_LoginMemberInfo");

			parameters.put("P_EMP_NO", emp_no);
			parameters.put("P_COMPANY_CD", this.getCompanyCode());

			System.out.println("parameters" + parameters);

			SqlPack so = new SqlPack();

			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.getInParameters().putAll(parameters);
			so.setSqlText(sqlText);

			List<Map<String, Object>> checkSdtl = this.queryForList(so);

			System.out.println("이 값은 로그인유저정보" + checkSdtl);
			return checkSdtl;

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}

	@DzApi(url = "/pammpm00200_ResNo", desc = "주민번호-조회", httpMethod = DzRequestMethod.GET)
	public List<Pammpm00200_Model> pammpm00200_ResNo(
			@DzParam(key = "emp_no", desc = "사원번호", paramType = DzParamType.QueryString) String emp_no)
			throws Exception {

		List<Pammpm00200_Model> pammpm00200_ModelList = new ArrayList<Pammpm00200_Model>();

		try {
			// 복호화 설정
			// BlackBoxUtil 초기화
			BlackBoxUtil BB = new BlackBoxUtil(this.getUserId(), this.getCompanyCode(), this.getGroupCode());

			List<EncParameter> encParameters = new ArrayList<>();

			EncParameter encParameter = new EncParameter();

			encParameter.setKeyField("res_no");
			encParameter.setValueField("res_no");
			encParameter.setTargetField("res_no");

			encParameter.setEncryptStyle(EncryptStyle.JUMIN);
			encParameters.add(encParameter);

			HashMap<String, Object> parameters = new HashMap<String, Object>();

			// mapper id 접근
			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pammpm00200_Dao.pammpm00200_ResNo");

			parameters.put("P_EMP_NO", emp_no);
			parameters.put("P_COMPANY_CD", this.getCompanyCode());

			System.out.println("parameters" + parameters);

			SqlPack so = new SqlPack();

			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.getInParameters().putAll(parameters);
			so.setSqlText(sqlText);

			pammpm00200_ModelList = this.queryForModel(so, Pammpm00200_Model.class);
			System.out.println("pammpm00200_ModelList" + pammpm00200_ModelList);

			BB.getDecryptTextList(pammpm00200_ModelList, encParameters);

			System.out.println("이 값은 " + pammpm00200_ModelList);
			return pammpm00200_ModelList;

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
}

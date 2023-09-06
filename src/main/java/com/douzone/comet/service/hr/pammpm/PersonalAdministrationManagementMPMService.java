package com.douzone.comet.service.hr.pammpm;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.comet.components.DzCometService;
import com.douzone.comet.cryptography.enums.EncryptStyle;
import com.douzone.comet.service.hr.pammpm.dao.Pammpm00200_Dao;
import com.douzone.comet.service.hr.pammpm.models.Pammpm00200_Model;
import com.douzone.comet.service.util.BlackBoxUtil;
import com.douzone.comet.service.util.StringUtil;
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
import com.douzone.gpd.restful.model.DzGridModel;

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
			parameters.put("P_BIZAREA_CD", bizarea_cd);
			parameters.put("P_COMPANY_CD", this.getCompanyCode());

			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pammpm00200_Dao.pammpm00200_InsuValDc");
			SqlPack so = new SqlPack();
			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.getInParameters().putAll(parameters);
			so.setSqlText(sqlText);

			List<Map<String, Object>> checkSdtl = this.queryForList(so);

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
			parameters.put("P_BIZAREA_CD", bizarea_cd);
			parameters.put("P_COMPANY_CD", this.getCompanyCode());

			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pammpm00200_Dao.pammpm00200_BizareaInfo");
			SqlPack so = new SqlPack();
			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.getInParameters().putAll(parameters);
			so.setSqlText(sqlText);

			List<Map<String, Object>> checkSdtl = this.queryForList(so);

			return checkSdtl;

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}

	@DzApi(url = "/pammpm00200_CharCdValDc", desc = "우선지원대상기업-조회", httpMethod = DzRequestMethod.GET)
	public List<Map<String, Object>> pammpm00200_CharCdValDc() throws Exception {

		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();

			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pammpm00200_Dao.pammpm00200_CharCdValDc");
			SqlPack so = new SqlPack();
			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.getInParameters().putAll(parameters);
			so.setSqlText(sqlText);

			List<Map<String, Object>> checkSdtl = this.queryForList(so);
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
			parameters.put("P_EMP_NO", emp_no);
			parameters.put("P_COMPANY_CD", this.getCompanyCode());

			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pammpm00200_Dao.pammpm00200_LoginMemberInfo");
			SqlPack so = new SqlPack();
			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.getInParameters().putAll(parameters);
			so.setSqlText(sqlText);

			List<Map<String, Object>> checkSdtl = this.queryForList(so);

			return checkSdtl;

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}

	// 주민번호 조회
	@DzApi(url = "/pammpm00200_ResNo", desc = "주민번호-조회", httpMethod = DzRequestMethod.GET)
	public String pammpm00200_ResNo(
			@DzParam(key = "emp_no", desc = "사원번호", paramType = DzParamType.QueryString) String emp_no)
			throws Exception {

		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("P_EMP_NO", emp_no);
			parameters.put("P_COMPANY_CD", this.getCompanyCode());

			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pammpm00200_Dao.pammpm00200_ResNo");
			SqlPack so = new SqlPack();
			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.getInParameters().putAll(parameters);
			so.setSqlText(sqlText);

			List<Pammpm00200_Model> pammpm00200_ModelList = this.queryForModel(so, Pammpm00200_Model.class);
			pammpm00200_ModelList.get(0).getRes_no();

			BlackBoxUtil BB = new BlackBoxUtil(this.getUserId(), this.getCompanyCode(), this.getGroupCode());

			String decrtptText = BB.getDecryptText(pammpm00200_ModelList.get(0).getRes_no(), EncryptStyle.JUMIN);
			System.out.println("반영전" + decrtptText);
			decrtptText = PAMMPM00200_Service.maskResNo(decrtptText);
			System.out.println("반영후" + decrtptText);
			return decrtptText;

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}

	// 마스터 그리드 업데이트
	@DzApi(url = "/Pammpm00200_MasterData_finish", desc = "마감처리", httpMethod = DzRequestMethod.POST)
	public void Pammpm00200_MasterData_finish(
			@DzParam(key = "mtnityidnfMaster_ds", desc = "마스터그리드-데이터소스", required = true, paramType = DzParamType.Body) DzGridModel<Pammpm00200_Model> mtnityidnfMaster_ds)
			throws Exception {
		try {
			 
			for (Pammpm00200_Model updateRow : mtnityidnfMaster_ds.getUpdated()) {
				updateRow.setCompany_cd(this.getCompanyCode());
				updateRow.setWrt_dt(StringUtil.getLocaleTimeString(updateRow.getWrt_dt(), "yyyyMMdd"));
				updateRow.setDecl_dt(StringUtil.getLocaleTimeString(updateRow.getDecl_dt(), "yyyyMMdd"));
				updateRow.setChldbrth_dt(StringUtil.getLocaleTimeString(updateRow.getChldbrth_dt(), "yyyyMMdd"));
				updateRow.setUpdate_id(this.getUserId());
				updateRow.setUpdate_dts(new Date());
				updateRow.setUpdate_ip(this.getRemoteHost());
			}
			// 마스터그리드 업데이트
			if (mtnityidnfMaster_ds.getUpdated() != null && mtnityidnfMaster_ds.getUpdated().size() > 0) {
				dao.updateMstBatch(mtnityidnfMaster_ds.getUpdated());
			}
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}
}

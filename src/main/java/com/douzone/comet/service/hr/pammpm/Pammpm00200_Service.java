package com.douzone.comet.service.hr.pammpm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.cryptography.enums.EncryptStyle;
import com.douzone.comet.service.hr.pammpm.dao.Pammpm00200_Dao;
import com.douzone.comet.service.hr.pammpm.models.Pammpm00200_Model;

import com.douzone.comet.service.util.BlackBoxUtil;
import com.douzone.comet.service.util.StringUtil;
import com.douzone.comet.service.util.api.models.EncParameter;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.gpd.restful.model.DzGridModel;

@DzApiService(value = "PAMMPM00200_Service", module = CometModule.HR, desc = "인사관리 - 모성보호관리")
public class PAMMPM00200_Service extends DzCometService {

	public static String maskResNo(String originalResNo) {
		String maskedResNo = originalResNo;
		if (originalResNo != null && originalResNo.length() >= 13) {
			maskedResNo = originalResNo.substring(0, 6) + "-*******";
		}
		return maskedResNo;
	}

	@Autowired
	Pammpm00200_Dao dao;

	@DzApi(url = "/Pammpm00200_selectAllData", desc = "출산휴가확인서등록-조회", httpMethod = DzRequestMethod.POST)
	public List<Pammpm00200_Model> pammpm00200_selectAllData(
			@DzParam(key = "wrtDt_start", desc = "시작일", paramType = DzParamType.Body) String wrtDt_start,
			@DzParam(key = "wrtDt_end", desc = "종료일", paramType = DzParamType.Body) String wrtDt_end,
			@DzParam(key = "req_knd_fg", desc = "신청종류", paramType = DzParamType.Body) String req_knd_fg,
			@DzParam(key = "keyword", desc = "검색어", paramType = DzParamType.Body) String keyword) throws Exception {
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
			System.out.println("encParameters" + encParameters);

			HashMap<String, Object> parameter = new HashMap<String, Object>();

			parameter.put("P_WRT_DT_START", wrtDt_start);
			parameter.put("P_WRT_DT_END", wrtDt_end);
			parameter.put("P_COMPANY_CD", this.getCompanyCode());
			parameter.put("P_REQ_KND_FG", req_knd_fg);
			parameter.put("P_KEYWORD", keyword);

			pammpm00200_ModelList = dao.Pammpm00200_selectAllData(parameter);

			// 실제 복호화 수행
			BB.getDecryptTextList(pammpm00200_ModelList, encParameters);

			for (Pammpm00200_Model item : pammpm00200_ModelList) {
				item.set_uid(UUID.randomUUID().toString());
				System.out.println("item" + item.getRes_no());
			}

			for (Pammpm00200_Model item : pammpm00200_ModelList) {
				String originalResNo = item.getRes_no();
				String maskedResNo = maskResNo(originalResNo);
				item.setRes_no(maskedResNo);
			}

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
		return pammpm00200_ModelList;
	}

	@DzApi(url = "/Pammpm00200_selectHrMtnityidnfDtl", desc = "출산휴가확인서서브등록-조회", httpMethod = DzRequestMethod.POST)
	public List<HashMap<String, Object>> Pammpm00200_selectHrMtnityidnfDtl(
			@DzParam(key = "doc_no", desc = "문서번호", required = false, paramType = DzParamType.Body) String doc_no,
			@DzParam(key = "emp_no", desc = "사원번호", required = false, paramType = DzParamType.Body) String emp_no)
			throws Exception {

		List<HashMap<String, Object>> pammpm00200_ModelList = new ArrayList<HashMap<String, Object>>();
		try {
			HashMap<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("P_DOC_NO", doc_no);
			parameter.put("P_EMP_NO", emp_no);
			parameter.put("P_COMPANY_CD", this.getCompanyCode());

			pammpm00200_ModelList = dao.Pammpm00200_selectHrMtnityidnfDtl(parameter);

			for (HashMap<String, Object> item : pammpm00200_ModelList) {
				item.put("_uid", UUID.randomUUID().toString());
				System.out.println("item" + item);
			}
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
		return pammpm00200_ModelList;
	}

	@Transactional(rollbackFor = Exception.class)
	@DzApi(url = "/pammpm00200_service_save", desc = "출산휴가확인서등록-저장", httpMethod = DzRequestMethod.POST)
	public void pammpm00200_service_save(
			@DzParam(key = "mtnityidnfMaster_ds", required = false, desc = "마스터그리드-데이터소스", paramType = DzParamType.Body) DzGridModel<Pammpm00200_Model> mtnityidnfMaster_ds,
			@DzParam(key = "mtnityidnfDtl_ds", required = false, desc = "서브그리드-데이터소스", paramType = DzParamType.Body) DzGridModel<Pammpm00200_Model> mtnityidnfDtl_ds)
			throws Exception {
		try {
			int count = 0;

			// [마스터그리드 추가]
			for (Pammpm00200_Model insertRow : mtnityidnfMaster_ds.getAdded()) {

				BlackBoxUtil bbu = new BlackBoxUtil(this.getUserId(), this.getCompanyCode(), this.getGroupCode());

				if (insertRow.getRes_no() != null) {
					String trgtp_Res_no = insertRow.getRes_no();
					trgtp_Res_no = bbu.addwithKey(trgtp_Res_no.toString().replace("-", ""), EncryptStyle.JUMIN);
					insertRow.setTrgtp_res_no(trgtp_Res_no); // 암호화된 주민번호
				}
				insertRow.setCompany_cd(this.getCompanyCode());
				insertRow.setWrt_dt(StringUtil.getLocaleTimeString(insertRow.getWrt_dt(), "yyyyMMdd"));
				insertRow.setDecl_dt(StringUtil.getLocaleTimeString(insertRow.getDecl_dt(), "yyyyMMdd"));
				insertRow.setChldbrth_dt(StringUtil.getLocaleTimeString(insertRow.getChldbrth_dt(), "yyyyMMdd"));
				insertRow.setInsert_id(this.getUserId());
				insertRow.setUpdate_id(this.getUserId());
				insertRow.setInsert_dts(new Date());
				insertRow.setUpdate_dts(new Date());
				insertRow.setInsert_ip(this.getRemoteHost());
				insertRow.setUpdate_ip(this.getRemoteHost());
				count = dao.selectMstPK(insertRow);

				System.out.println("count 갯수" + count);

				if (count > 0) {
					System.out.println("good throw");
					throw new DzApplicationRuntimeException("이미 등록된 마스터출산등록이력이 있습니다.\n재조회 후 처리하십시오.");
				}

			}
			// [서브그리드 추가]
			for (Pammpm00200_Model insertRow : mtnityidnfDtl_ds.getAdded()) {

				insertRow.setStart_dt(StringUtil.getLocaleTimeString(insertRow.getStart_dt(), "yyyyMMdd")); // 시작일
				insertRow.setEnd_dt(StringUtil.getLocaleTimeString(insertRow.getEnd_dt(), "yyyyMMdd")); // 종료일
				insertRow.setCompany_cd(this.getCompanyCode());
				insertRow.setInsert_id(this.getUserId());
				insertRow.setUpdate_id(this.getUserId());
				insertRow.setInsert_dts(new Date());
				insertRow.setUpdate_dts(new Date());
				insertRow.setInsert_ip(this.getRemoteHost());
				insertRow.setUpdate_ip(this.getRemoteHost());
				count = dao.selectDtlPK(insertRow);

				System.out.println("count 갯수" + count);
				if (count > 0) {
					System.out.println("good throw");
					throw new DzApplicationRuntimeException("이미 등록된 그리드출산등록이력이 있습니다.\n재조회 후 처리하십시오.");
				}
				dao.insertDtl(insertRow); // 한줄씩 추가
			}
			// [마스터그리드 수정]
			for (Pammpm00200_Model updateRow : mtnityidnfMaster_ds.getUpdated()) {
				updateRow.setCompany_cd(this.getCompanyCode());
				updateRow.setWrt_dt(StringUtil.getLocaleTimeString(updateRow.getWrt_dt(), "yyyyMMdd"));
				updateRow.setDecl_dt(StringUtil.getLocaleTimeString(updateRow.getDecl_dt(), "yyyyMMdd"));
				updateRow.setChldbrth_dt(StringUtil.getLocaleTimeString(updateRow.getChldbrth_dt(), "yyyyMMdd"));
				updateRow.setUpdate_id(this.getUserId());
				updateRow.setUpdate_dts(new Date());
				updateRow.setUpdate_ip(this.getRemoteHost());
			}
			// [서브그리드 수정]
			for (Pammpm00200_Model updateRow : mtnityidnfDtl_ds.getUpdated()) {
				updateRow.setStart_dt(StringUtil.getLocaleTimeString(updateRow.getStart_dt(), "yyyyMMdd")); // 시작일
				updateRow.setEnd_dt(StringUtil.getLocaleTimeString(updateRow.getEnd_dt(), "yyyyMMdd")); // 종료일
				updateRow.setCompany_cd(this.getCompanyCode());
				updateRow.setUpdate_id(this.getUserId());
				updateRow.setUpdate_dts(new Date());
				updateRow.setUpdate_ip(this.getRemoteHost());
			}
			// [마스터그리드 삭제 => 디테일그리드 삭제]
			for (Pammpm00200_Model deleteRow : mtnityidnfMaster_ds.getDeleted()) {
				deleteRow.setCompany_cd(this.getCompanyCode());
				dao.deleteDtl(deleteRow);
				System.out.println("디테일 삭제완료 ");
			}
			// [서브그리드 삭제]
			if (mtnityidnfMaster_ds.getDeleted() != null && mtnityidnfMaster_ds.getDeleted().size() > 0) {
				dao.deleteMstBatch(mtnityidnfMaster_ds.getDeleted());
				System.out.println("마스터 삭제완료 ");
			}
			// [디테일그리드 삭제]
			for (Pammpm00200_Model deleteRow : mtnityidnfDtl_ds.getDeleted()) {
				deleteRow.setCompany_cd(this.getCompanyCode());
				dao.deleteDtl(deleteRow);
				System.out.println("디테일 삭제완료 ");
			}

			// [마스터그리드 삭제 => 디테일그리드 삭제]
			for (Pammpm00200_Model deleteRow : mtnityidnfMaster_ds.getDeleted()) {
				deleteRow.setCompany_cd(this.getCompanyCode());
				dao.deleteDtl(deleteRow);
				System.out.println("디테일 삭제완료 ");
			}

			// [마스터그리드 추가]
			if (mtnityidnfMaster_ds.getAdded() != null && mtnityidnfMaster_ds.getAdded().size() > 0) {
				dao.insertMstBatch(mtnityidnfMaster_ds.getAdded());
				System.out.println("마스터그리드 추가완료");
			}
			// [마스터그리드 업데이트]
			if (mtnityidnfMaster_ds.getUpdated() != null && mtnityidnfMaster_ds.getUpdated().size() > 0) {
				dao.updateMstBatch(mtnityidnfMaster_ds.getUpdated());
				System.out.println("마스터 업데이트완료 ");
			}
			// [서브그리드 업데이트]
			if (mtnityidnfDtl_ds.getUpdated() != null && mtnityidnfDtl_ds.getUpdated().size() > 0) {
				dao.updateDtlBatch(mtnityidnfDtl_ds.getUpdated());
				System.out.println("서브 업데이트완료 ");
			}
			// [마스터그리드 업데이트]
			if (mtnityidnfMaster_ds.getUpdated() != null && mtnityidnfMaster_ds.getUpdated().size() > 0) {
				dao.updateMstBatch(mtnityidnfMaster_ds.getUpdated());
				System.out.println("마스터 업데이트완료 ");
			}
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}
}

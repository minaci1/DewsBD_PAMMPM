package com.douzone.comet.service.hr.pammpm;

import java.util.ArrayList;
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
import com.douzone.comet.service.util.api.models.EncParameter;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.gpd.restful.model.DzGridModel;

/**
 * @description :
 * @Since :
 * @Author :
 * @History :
 */
@DzApiService(value = "PAMMPM00200_Service", module = CometModule.HR, desc = "인사관리 - 모성보호관리")
public class PAMMPM00200_Service extends DzCometService {

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

			System.out.println("여기옴ss? ??");
			System.out.println("parameter: " + parameter.toString());
			pammpm00200_ModelList = dao.Pammpm00200_selectAllData(parameter);
			
			BB.getDecryptTextList(pammpm00200_ModelList, encParameters);
			
			// 실제 복호화 수행
			for (Pammpm00200_Model item : pammpm00200_ModelList) {
				item.set_uid(UUID.randomUUID().toString());
				System.out.println("item" + item);
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
			System.out.println("여기옴?");
			HashMap<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("P_DOC_NO", doc_no);
			parameter.put("P_EMP_NO", emp_no);
			parameter.put("P_COMPANY_CD", this.getCompanyCode());

			System.out.println(parameter.toString());

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
			@DzParam(key = "keyword", desc = "검색어", paramType = DzParamType.Body) DzGridModel<Pammpm00200_Model> keyword)
			throws Exception {
		try {
			// update

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}
}

package com.douzone.comet.service.hr.pammpm.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.pammpm.models.Pammpm00200_Model;

/**
 * @description :
 * @Since :
 * @Author :
 * @History :
 */
@Repository
public class Pammpm00200_Dao {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public Pammpm00200_Dao(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	// 마스터복수 데이터 목록 조회
	public List<Pammpm00200_Model> Pammpm00200_selectAllData(HashMap<String, Object> parameter) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".Pammpm00200_selectAllData", parameter);
	}

	// 서브복수 데이터 목록 조회
	public List<HashMap<String, Object>> Pammpm00200_selectHrMtnityidnfDtl(HashMap<String, Object> parameter)
			throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".Pammpm00200_selectHrMtnityidnfDtl",
				parameter);
	}

	// 중복 마스터그리드 데이터 조회
	public Integer selectMstPK(Pammpm00200_Model parameters) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectMstPK", parameters);
	}

	// 중복 서브그리드 데이터 조회
	public Integer selectDtlPK(Pammpm00200_Model parameters) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectDtlPK", parameters);
	}

	// 마스터그리드 입력 처리
	public void insertMstBatch(List<Pammpm00200_Model> parameters) throws Exception {
		this.mybatisSupport.insertBatch(this.getClass().getName() + ".insertMstBatch", parameters);
	}

	// 사업장 데이터 입력처리
	public void insertBizreaInfo() throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insertBizreaInfo");
	}

	// 서브그리드 입력 처리
	public void insertDtl(Pammpm00200_Model parameters) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insertDtl", parameters);
	}

	// 마스터 업데이트 처리
	public void updateMstBatch(List<Pammpm00200_Model> parameters) throws Exception {
		this.mybatisSupport.updateBatch(this.getClass().getName() + ".updateMstBatch", parameters);
	}

	// 서브 업데이트 처리
	public void updateDtlBatch(List<Pammpm00200_Model> parameters) throws Exception {
		this.mybatisSupport.updateBatch(this.getClass().getName() + ".updateDtlBatch", parameters);
	}

	// 마스터 삭제 처리
	public void deleteMstBatch(List<Pammpm00200_Model> parameters) throws Exception {
		this.mybatisSupport.deleteBatch(this.getClass().getName() + ".deleteMstBatch", parameters);
	}

	// 서브그리드 삭제 처리
	public void deleteDtl(Pammpm00200_Model parameters) throws Exception {
		this.mybatisSupport.delete(this.getClass().getName() + ".deleteDtl", parameters);
	}

}

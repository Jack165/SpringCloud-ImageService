package com.feng.house.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.feng.house.entity.Contract;
import com.feng.house.entity.Cost;
import com.feng.house.entity.Login;
import com.feng.house.entity.UserInfo;
import com.feng.house.enums.ContractState;
import com.feng.house.mapper.ContractMapper;
import com.feng.house.mapper.CostMapper;
import com.feng.house.mapper.LoginMapper;
import com.feng.house.mapper.UserInfoMapper;
import com.feng.house.request.ContractRequest;
import com.feng.house.response.ContractListRes;
import com.feng.house.response.Response;

@Component
public class ContractManager {
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	ContractMapper contractMapper;
	@Autowired
	CostMapper costMappper;
	
	@Autowired
	LoginMapper loginMapper;
	
	@Transactional
	public Boolean addControct(ContractRequest request) {
		UserInfo user=request.getRenter();
		UserInfo find=new UserInfo();
		find.setIdCard(user.getIdCard());
		UserInfo findRenter= userInfoMapper.selectOne(find);
		
		if(null==findRenter) {
			if(user.getIdCard().length()<10) {
				return false;
			}
			Login login=new Login();
			login.setPassword(user.getIdCard().substring(user.getIdCard().length()-6, user.getIdCard().length()));
			login.setUserName(user.getName());
			login.setAccount(user.getCellPhone());
			loginMapper.insert(login);
		   user.setAccount(user.getCellPhone());
		   userInfoMapper.insert(user);
		   findRenter= userInfoMapper.selectOne(find);
		}
		Contract contract=request.getContract();
		String group=user.getIdCard()+contract.getHousownerId()+contract.getHousePropertyId();
		List<Cost> costList=request.getCostList();
		for(Cost cost:costList) {
			cost.setGroupId(group);
			costMappper.insert(cost);
		}
		contract.setRenterId(findRenter.getId());
		contract.setRenterName(findRenter.getName());

		UserInfo houseOwner=userInfoMapper.selectById(contract.getHousownerId());
		contract.setHouseownerName(houseOwner.getName());
		contract.setCostGroup(group);
		contractMapper.insert(contract);
		return true;
		
	}
	
	public List<ContractListRes> getContralistByowner(Integer userId){
		List<ContractListRes> result=new ArrayList<>();
		Contract params=new Contract();
		params.setHousownerId(userId);
		EntityWrapper<Contract> sqlParams=new EntityWrapper<>(params);
		List<Contract> contractList=contractMapper.selectList(sqlParams);
		if(null!=contractList&&contractList.size()>0) {
			for(Contract c:contractList) {
				ContractListRes res=ContractListRes.builder()
						.id(c.getId())
						.name(c.getRenterName())
						.room(c.getHousePropertyName())
						.status(ContractState.getDescByid(c.getStatus()))
						.build();
				result.add(res);
			}
			
		}
		return result;
	}
	
	
	public List<ContractListRes> getContralistRenter(Integer userId){
		List<ContractListRes> result=new ArrayList<>();
		Contract params=new Contract();
		params.setRenterId(userId);
		EntityWrapper<Contract> sqlParams=new EntityWrapper<>(params);
		List<Contract> contractList=contractMapper.selectList(sqlParams);
		if(null!=contractList&&contractList.size()>0) {
			for(Contract c:contractList) {
				ContractListRes res=ContractListRes.builder()
						.id(c.getId())
						.name(c.getRenterName())
						.room(c.getHousePropertyName())
						.status(ContractState.getDescByid(c.getStatus()))
						.build();
				result.add(res);
			}
			
		}
		return result;
	}
	
	
	public ContractRequest getContract(Integer id) {
		System.out.println(id);
		ContractRequest result=new ContractRequest();
		Contract contract =contractMapper.selectById(id);
		if(null==contract) {
			return result;
		}

		List<Cost> costList= costMappper.getCostByGroup(contract.getCostGroup());
		UserInfo ranter=userInfoMapper.selectById(contract.getRenterId());
		result.setRenter(ranter);
		result.setContract(contract);
		result.setCostList(costList);
		return result;
	}
	
	
}

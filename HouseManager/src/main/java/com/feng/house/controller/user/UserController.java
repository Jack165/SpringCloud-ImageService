package com.feng.house.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feng.house.entity.Login;
import com.feng.house.entity.UserInfo;
import com.feng.house.mapper.LoginMapper;
import com.feng.house.mapper.UserInfoMapper;
import com.feng.house.request.LoginReq;
import com.feng.house.request.UpdatePwdReq;
import com.feng.house.response.Response;
import com.feng.house.response.UserRes;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserInfoMapper usermapper;
	
	@Autowired
	LoginMapper loginMapper;
	
	
	@RequestMapping("/getUser")
	@ResponseBody
	public Response getUser(@RequestBody LoginReq request) {
		
		Login userInfo=new Login();
		userInfo.setAccount(request.getAccount());
		userInfo.setPassword(request.getPwd());
		userInfo= loginMapper.selectOne(userInfo);
		if(null!=userInfo) {
			UserRes result=new UserRes();
			result.setAccount(userInfo.getAccount());
			
			result.setId(userInfo.getId());
			UserInfo user=usermapper.selectById(userInfo.getUserId());
			result.setCellPhone(user.getCellPhone());
			result.setName(user.getName());
			return  Response.successResultObject(result);
		}else {
			return Response.resultmsg( "登陆失败",100);
		}
		
	}
	@RequestMapping("/update_user_password")
	@ResponseBody
	public Response updateUserPassword(@RequestBody UpdatePwdReq req) {
		
		Login check=loginMapper.checkUser(req.getOldPwd(), req.getUserId());
		if(null!=check) {
			loginMapper.updatePassword(req.getNewPwd(), req.getUserId());
			return Response.resultSuccess();
		}else {
			return Response.resultFail();
		}
		
		
	}
	
	
	
}

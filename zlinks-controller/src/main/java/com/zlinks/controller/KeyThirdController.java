package com.zlinks.controller;
import com.zlinks.domain.KeyThird;
import com.zlinks.service.KeyThirdService;
import com.zlinks.common.web.BaseController;
import com.zlinks.common.web.JsonResult;
import com.zlinks.common.web.PageResult;
import com.zlinks.common.web.RestDoing;
import com.zlinks.Routes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
/**
 * Copyright (C), 2017-2020, BBG
 * FileName: KeyThirdController
 * Author:   zhangjh
 * Date:     2018-7-9 19:08:15
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class KeyThirdController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private KeyThirdService keyThirdService;




	/**
     * @api {post} /keyThirds/save 01. KeyThird删除
     * @apiPermission Login in Users
     * @apiGroup  KeyThird
     * @apiVersion 1.0.1
	 * @apiParam {Number} id <code>必须参数</code> id
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:15:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:15:479"
     * }
     */
	@RequestMapping(value = "/keyThirds/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(@PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = keyThirdService.delete(keyThird);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /keyThirds/save 02. KeyThird详细信息
     * @apiPermission Login in Users
     * @apiGroup  KeyThird
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:15:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:15:479"
     * }
     */
	@RequestMapping(value = "/keyThirds/info/{id}")
	public JsonResult info(@PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			KeyThird entity  = keyThirdService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /keyThirds/list 03. KeyThird列表查询
     * @apiPermission Login in Users
     * @apiGroup  KeyThird
     * @apiVersion 1.0.1
	 * @apiParam {Number} pageNo <code>必须参数</code> 页码，从1开始
	 * @apiParam {Number} pageSize <code>必须参数</code> 页码，每页显示的记录数量
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:15:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:15:479"
     * }
     */
	@RequestMapping(value = "/keyThirds/list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<KeyThird> data = keyThirdService.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}


	/**
     * @api {post} /keyThirds/save 03. KeyThird新增
     * @apiPermission Login in Users
     * @apiGroup  KeyThird
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:15:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:15:479"
     * }
     */
	@RequestMapping(value = "/keyThirds/save", method = RequestMethod.POST)
	public JsonResult add(@RequestBody KeyThird keyThird) {

  		RestDoing doing = jsonResult -> {

            int counts = keyThirdService.add(keyThird);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /keyThirds/update/{id} 03. KeyThird修改
     * @apiPermission Login in Users
     * @apiGroup  KeyThird
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> KeyThird的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:15:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:15:479"
     * }
     */
	@RequestMapping(value = "/keyThirds/save", method = RequestMethod.PUT)
	public JsonResult add(@RequestBody KeyThird keyThird) {

  		RestDoing doing = jsonResult -> {

            int counts = keyThirdService.add(keyThird);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}

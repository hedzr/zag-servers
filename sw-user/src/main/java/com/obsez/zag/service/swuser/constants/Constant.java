package com.obsez.zag.service.swuser.constants;

/**
 * Created by hedzr on 2015/6/3.
 */
public interface Constant {

    int WX_USER=1;
    int APP_USER=2;

    int CODE_REQUEST_NORESULT = 444;// 查询没有数据
    int PARAM_EMPTY = 445;// 参数为空
    int PARAM_ERROR = 446;// 参数不正确
    int CODE_REQUEST_SUCCESS = 100;// 操作成功
    int CODE_REQUEST_FAILURE = 500;// 操作失败
    int NOTFIND_FAILURE=501;//未找到

    int LOGIN_ERROR=100;//登陆异常
    int CREATE_ERROR=101;//新增异常
    int UPDATE_ERROR=102;//修改异常
}

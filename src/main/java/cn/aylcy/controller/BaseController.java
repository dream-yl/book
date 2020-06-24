package cn.aylcy.controller;

import cn.aylcy.service.ex.ServiceException;
import cn.aylcy.util.JsonResult;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**.
 * 所用控制器类的父类
 */
public abstract class BaseController {

  protected static final String SESSION_UID = "uid";
  protected static final String SESSION_USERNAME = "username";
  //状态码：200请求成功
  protected static final Integer SUCCESS = 200;
  //状态码：250失败(出现异常)
  protected static final Integer ERROR_USERNAME_DUPLICATE = 250;

  /**.
   * 对控制器中的异常进行统一处理
   * 
   * @param e 异常对象
   * @return JsonResult封装响应信息
   */
  @ExceptionHandler({ ServiceException.class, FileUploadException.class })
  @ResponseBody
  public JsonResult<Void> handlerException(Throwable e) {
    // 根据不同异常的类型提供不同的处理方式
    // 现在的处理方式是根据不同的类型，返回不同的状态码
    JsonResult<Void> jr = new JsonResult<>(e.getMessage());
    jr.setState(ERROR_USERNAME_DUPLICATE);
    return jr;
  }

  public String getUsernameFromSession(HttpSession session) {
    // 从session中获取username
    return session.getAttribute(SESSION_USERNAME).toString();
  }

  public Integer getUidFromSession(HttpSession session) {
    // 从session中获取uid
    return Integer.valueOf(session.getAttribute(SESSION_UID).toString());
  }

}

package cn.aylcy.controller;

import cn.aylcy.entity.Book;
import cn.aylcy.service.BookService;
import cn.aylcy.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 书籍控制层
 */
@Controller
@RequestMapping("books")
public class BookController extends BaseController {

    @Autowired
    BookService bookService;

    /**
     * 添加书籍
     *
     * @param titleName书名
     * @param authorName作者
     * @param unitPrice单价
     * @param briefIntroduction简介
     * @return
     */
    @RequestMapping("addBook")
    @ResponseBody
    public JsonResult<Void> addBook(String titleName, String authorName,
                                    String unitPrice, String briefIntroduction) {
        JsonResult<Void> result = new JsonResult<>();
        Book book = new Book();
        book.setTitleName(titleName);
        book.setAuthorName(authorName);
        book.setUnitPrice(Double.parseDouble(unitPrice));
        book.setBriefIntroduction(briefIntroduction);
        System.out.println(book);
        bookService.addBook(book);
        result.setState(SUCCESS);
        return result;
    }

    /**
     * 编辑
     *
     * @param titleName
     * @param authorName
     * @param unitPrice
     * @param briefIntroduction
     * @return
     */
    @RequestMapping("updateBook")
    @ResponseBody
    public JsonResult<Void> updateBook(Integer bid, String titleName, String authorName,
                                       String unitPrice, String briefIntroduction) {
        JsonResult<Void> result = new JsonResult<>();
        Book book = new Book();
        book.setBid(bid);
        book.setTitleName(titleName);
        book.setAuthorName(authorName);
        book.setUnitPrice(Double.parseDouble(unitPrice));
        book.setBriefIntroduction(briefIntroduction);
        bookService.updateBook(book);
        result.setState(SUCCESS);
        return result;
    }

    /**
     * 删除
     *
     * @param bid
     * @return
     */
    @RequestMapping("deleteBook")
    @ResponseBody
    public JsonResult<Void> deleteBook(Integer bid) {
        JsonResult<Void> result = new JsonResult<>();
        bookService.deleteBook(bid);
        result.setState(SUCCESS);
        return result;
    }

    /**
     * 通过id查询详情
     *
     * @param bid
     * @return
     */
    @RequestMapping("findBookById")
    @ResponseBody
    public JsonResult<Book> findBookById(Integer bid) {
        JsonResult<Book> result = new JsonResult<>();
        Book data = bookService.findBookById(bid);
        result.setData(data);
        result.setState(SUCCESS);
        return result;
    }

    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping("findBookAll")
    @ResponseBody
    public JsonResult<List<Book>> findBookAll(String titleName) {
        JsonResult<List<Book>> result = new JsonResult<>();
        List<Book> data = bookService.findBookAll(titleName);
        result.setData(data);
        result.setState(SUCCESS);
        return result;
    }
}

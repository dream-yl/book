package cn.aylcy.service.impl;

import cn.aylcy.entity.Book;
import cn.aylcy.mapper.BookMapper;
import cn.aylcy.service.BookService;
import cn.aylcy.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 书籍业务层实现类
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;


    @Override
    public void addBook(Book book) {
        if("".equals(book.getTitleName()) || book.getTitleName() == null
        || "".equals(book.getAuthorName()) || book.getAuthorName() == null
        || "".equals(book.getUnitPrice()) ){
            throw  new UserNotFoundException("请把信息补充完整！");
        }
        bookMapper.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        if("".equals(book.getTitleName()) || book.getTitleName() == null
                || "".equals(book.getAuthorName()) || book.getAuthorName() == null
                || "".equals(book.getUnitPrice()) ){
            throw  new UserNotFoundException("请把信息补充完整！");
        }
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookMapper.deleteBook(id);
    }

    @Override
    public Book findBookById(Integer id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public List<Book> findBookAll(String titleName) {
        return bookMapper.findBookAll(titleName);
    }
}

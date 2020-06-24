package cn.aylcy.service;

import cn.aylcy.entity.Book;

import java.util.List;

/**
 * 书籍业务层接口
 */
public interface BookService {

    /**
     * 添加
     *
     * @param book
     * @return
     */
    void addBook(Book book);

    /**
     * 编辑
     *
     * @param book
     * @return
     */
    void updateBook(Book book);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    void deleteBook(Integer id);

    /**
     * 通过id查询详情
     *
     * @param id
     * @return
     */
    Book findBookById(Integer id);

    /**
     * 查询全部未删除的
     *
     * @return
     */
    List<Book> findBookAll(String titleName);
}

package cn.aylcy.mapper;

import cn.aylcy.entity.Book;

import java.util.List;

/**
 * 书籍持久层接口
 */
public interface BookMapper {

    /**
     * 添加
     * @param book
     * @return
     */
    Integer addBook(Book book);

    /**
     * 编辑
     * @param book
     * @return
     */
    Integer updateBook(Book book);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer deleteBook(Integer id);

    /**
     * 通过id查询详情
     * @param id
     * @return
     */
    Book findBookById(Integer id);

    /**
     * 查询全部未删除的
     * @return
     */
    List<Book> findBookAll(String titleName);
}

package org.zerock.dao;

import jdk.vm.ci.meta.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2023,1,2))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {
        System.out.println(todoDAO.SelectOne(2L));
    }

    @Test
    public void testDeleteOne() throws Exception {
        todoDAO.deleteOne(3L);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO vo = TodoVO.builder()
                    .tno(2L)
                    .title("Updated Title")
                    .dueDate(LocalDate.of(2023,1,5))
                    .finished(true)
                    .build();
        todoDAO.updateOne(vo);
    }
}

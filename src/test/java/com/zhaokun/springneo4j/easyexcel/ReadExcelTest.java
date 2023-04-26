package com.zhaokun.springneo4j.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaok
 * @Date 2023/2/22 21:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReadExcelTest {

    /**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>3. 直接读即可
     */
//    @Test
//    public void simpleRead() {
//        String fileName = "";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, UserDao.class).sheet().doRead();
//    }

}
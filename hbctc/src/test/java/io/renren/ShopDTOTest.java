package io.renren;

import java.util.ArrayList;
import java.util.List;

import com.xuxueli.poi.excel.ExcelExportUtil;
import com.xuxueli.poi.excel.ExcelImportUtil;

import io.renren.modules.hbctc.entity.FundFrom;

/**
 * FUN Test
 *
 * @author xuxueli 2017-09-08 22:41:19
 */
public class ShopDTOTest {

	public static void main(String[] args) {

		/**
		 * Mock数据，Java对象列表
		 */
		List<FundFrom> shopDTOList = new ArrayList<FundFrom>();
		for (int i = 0; i < 50; i++) {
			FundFrom fd=new FundFrom("detpname", "deptno", "moneyway", "buyitemtype", 10000.0);
			shopDTOList.add(fd);
		}
		String filePath = "C:\\Users\\yan\\Desktop\\EXCEL\\fd-sheet.xls";

		/**
		 * Excel导出：Object 转换为 Excel
		 */
		ExcelExportUtil.exportToFile(filePath, shopDTOList, shopDTOList);

		/**
		 * Excel导入：Excel 转换为 Object
		 */
		List<Object> list = ExcelImportUtil.importExcel(FundFrom.class, filePath);

		System.out.println(list);

	}

}
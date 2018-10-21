/**  
 * All rights Reserved, Designed By www.blueintelligencewh.com
 * @Title:  Java8groupby.java   
 * @Package io.renren   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 武汉蓝智 
 * @date:   2018年10月21日 下午6:56:42   
 * @version V1.0 
 * @Copyright: 2018 www.blueintelligencewh.com Inc. All rights reserved. 
 * 注意：本内容仅限武汉蓝智科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */  
package io.renren;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;

/**
 * @author yan
 *
 */
public class Java8groupby {
	public static void main(String[] args) {
		ArrayList<Foo> list = Lists.newArrayList(
				new Foo(4, 2),
				new Foo(1, 3),
				new Foo(1, 3),
				new Foo(2, 2),
				new Foo(2, 5),
				new Foo(2, 9),
				new Foo(3, 9),
				new Foo(3, 9),
				new Foo(3, 9)
				);		

		//mapItem(list);
		boolean check = check(2,3);
		
		System.out.println(check);
		if(!check) {
			System.out.println("check: "+check);
		}
	}

	public  static void gpsum(ArrayList<Foo>  list) {//分組求和
		Map<Integer, IntSummaryStatistics> collect = list.stream().collect(Collectors.groupingBy(Foo::getCode, Collectors.summarizingInt(Foo::getCount)));
		System.out.println(collect);
		
	}
	
	public static void mapItem(ArrayList<Foo>  list) {
		List<Integer> collect = list.parallelStream().map(f->f.getCode()).collect(Collectors.toList());
		System.out.println(collect);
	}
	
	public static boolean check(int a,int b) {
		if(a>b) {
			return false;
		}
		return true;
	}


}

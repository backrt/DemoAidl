// DemoAidl.aidl
package com.demoaidl;

// Declare any non-default types here with import statements
import com.demoaidl.bean.Person;

interface DemoAidl {

//方法参数中，除了基本数据类型，其他类型的参数都需要标上方向类型
//in(输入), out(输出), inout(输入输出)
  void addPersion(in Person person);

  List<Person> getPersonList();
}

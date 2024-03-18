package com.example.abc.every;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.example.abc.model") //命名規則:Testxxx.java,否則明確指向類別
@IncludeTags({"d20240318","sss"})
//@SelectClasses()
public class TestJU {

}

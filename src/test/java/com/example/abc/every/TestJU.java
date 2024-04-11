package com.example.abc.every;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.example.abc.model") //命名規則:Test_xx.java, 開頭需要有Test
@IncludeTags({"demo20240318值測試","20240318by密碼"})
//@SelectClasses()
public class TestJU {}











































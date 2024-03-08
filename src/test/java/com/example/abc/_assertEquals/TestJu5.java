package com.example.abc._assertEquals;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

//直接 Run執行
@RunWith(JUnitPlatform.class)

//a.
//@SelectPackages({"com.example.abc._assertEquals"})

//b.
@SelectPackages("com.example.abc._assertEquals")
@IncludeTags("production")

//c.
//@SelectClasses({AddTest.class , MinTest.class})

public class TestJu5 {}

###Team简单命名约束

> 1. Activity，Fragment等必须以后缀Activity，Fragment结尾
> 
> 2. 类变量必需加上属性修饰符(例如private,而且最好用private),private变量在变量名前加`m`(比如`mTestButton`)，static类型的加`s`
> 
> 3. 类变量中控件名必须以控件名字结尾(比如`mTestButton`, `mInputEditText`)
> 
> 4. xml文件中，命名为 所在类_控件名缩写_功能(比如`main_et_username`, `reset_password_btn_confirm`)
> 
> 5. 图片文件放在`mip_map`文件夹下xml文件放在drawable下（比如shape，selector），图标一律以`icon_***`开头
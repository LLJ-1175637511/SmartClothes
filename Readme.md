1.更改项目git仓库地址

    git remote set-url origin xxx
    
    使用命令确认地址是否修改成功： 

    git remote -v

2.修改项目名

    优先. 退出项目 修改项目名称 重新打开
    a. settings.gradle文件:修改rootProject.name
    b. 展开 .idea ，打开 .name文件 修改名称 
    c. 修改 项目名.iml 
    d. 修改 modules.xml  


import subprocess

listDevicesCmd='adb devices'
listDevicesOutput=subprocess.Popen(listDevicesCmd,shell=True,stdout=subprocess.PIPE)
allConnectedDevices=str(listDevicesOutput.stdout.read(),encoding='utf-8')
print(allConnectedDevices)


listLogcatCmd='adb logcat'
listLogcatOutput=subprocess.Popen(listLogcatCmd,shell=True,stdout=subprocess.PIPE)
# LogcatOutput=str(listLogcatOutput.stdout.read(),encoding='utf-8')
# 实时的打印出日志信息
# 这里我们就用到了readline方法，其实这种写法类似我们读取文件，单行读取和全部内容读取。
for i in iter(listLogcatOutput.stdout.readline,'b'):
    print(str(i,encoding='utf-8'))

# 最终目的是我们找到需要的功能命令获取结果数据，然后再去通过Python处理这些返回数据，实现自动化测试的目的。

# adb 命令举例
# 比如我们针对一个设备去进行点击操作，命令的写法应该是这样：
# adb -s 49dsd4554wdsa shell input tap 600 900，其中'49dsd4554wdsa'是设备号，'600 900'点击屏幕坐标。
# adb shell input tap 600 900

# 在每条的命令后加一句 -h 或是-help，可以查询一下该条命令的相关使用帮助信息。比如我们在cmd中输入 adb shell input -help，会返回命令相关的使用方法
# []中括号里的内容表示可以带也可以不带，<>尖括号就是必须带上的内容
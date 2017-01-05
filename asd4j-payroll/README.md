# 薪水支付案例

## 业务分析

雇员：

- 钟点工
- 月薪雇员
- 带薪雇员

支付方式：支票邮寄；支票保存在出纳员；银行汇款

协会

用例：

1. 增加新雇员
2. 删除雇员
3. 登机时间卡
......


P178 核心模型类图

找出潜在的抽象

P184 AddEmployeeTransaction 静态模型 
P192 TimeCardTransaction 模型
P193 SalesReceiptTransaction 模型
P194 ServiceChargeTransaction 模型
P208 支付的动态情景模型


为什么用 Map存 SalesReceipt 和 TimeCard 等,而不是用List?
暂时的考虑是:一个速度问题,一个是多次赋值同一Date可覆盖前值,List不行(直接)。
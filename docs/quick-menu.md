# 快捷清单
主要用来展示当前最最关心的任务，当用户有很多任务的时候，用户很难选择当前该做什么，并且极易被不重要的任务分心，所以快捷清单的任务不应该超过五个。

## 任务定义
### 基本任务定义属性
| 字段名      | 类型   | 解释           | 取值              |
|-------------|--------|----------------|-------------------|
| name        | String | 任务名         |                   |
| content     | String | 内容           |                   |
| tag         | String | 任务类型       | 笔记，开发等等    |
| taskType    | Enum   | 应用任务类型   | QUICK, GLASS      |
| taskStatus  | Enum   | 任务状态       | TODO, DOING, DONE |
| deadDate    | Date   | 截止日期       |                   |
| deadDateStr | String | 截止日期字符串 |                   |

### 扩展的任务定义
+ 相关人员
+ 任务依赖
+ 任务信息
+ 提醒时间
+ 等等

## 需求
+ 快捷清单可以添加任务，最多添加五个任务
+ 超过五个，最不重要的任务将被放到集草器清单
+ 任务完成和取消将会归档，用于用户查询
+ 当任务少于五个时，集草器清单中最重要的任务将自动添加到快捷清单。
+ 快捷清单任务也可以被移到集草器清单中
+ 快捷清单可以选中一个任务并锁定，那么快捷清单只展示该任务，直到解锁或者该任务完成。
+ 锁定的任务不展示截止日期(不给用户带来时间紧迫感)

## 其他
任务的执行时间应该得以控制在四个小时之内
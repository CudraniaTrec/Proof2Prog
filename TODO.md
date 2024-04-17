1. 训练数据准备
- [x] AST的设计
- [x] 从java代码到内存模型的翻译
- [x] 从内存模型到java代码的翻译
- [x] coq建模 AST 并构建类型推导规则
- [x] 从内存模型到coq证明的翻译
2. 模型训练
- [ ] 训练
3. 测试输出
- [ ] 从coq证明到内存模型（再到Java代码）的转换
4. 不足
- [ ] 外部的method invocation/field access默认均可进行
- [ ] constructor等多态函数的识别
- [ ] foreach 对于array 和class对象要分开处理
- [ ] string和string/char可以相加
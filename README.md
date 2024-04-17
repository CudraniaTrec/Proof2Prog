## 环境
1. The Coq Proof Assistant, version 8.18.0
   compiled with OCaml 4.14.0
2. python 3.8.18
   (tree-sitter                0.20.4
    tree-sitter-languages      1.10.2)
    
## 文档结构
1. TODO.md: 项目进展
2. Makefile: 自动编译 Coq 文件
3. _CoqProject: Coq 项目结构，Makefile 的依赖
4. coq_code: Coq 代码
   - Syntax.v: Coq 定义的语法以及类型分析
   - test.v: 测试一个证明能够被接受
5. translation: java代码到 Coq 证明的翻译
   - program_model.py: 内存形式的程序模型
   - utils.py: 翻译 Java 程序到内存形式的程序
   - run.ipynb: 实际运行整个翻译流程
   - solutions: 所有的 Java 程序(leetcode benchmark)
   - mbjp: 所有的 Java 程序(mbjp benchmark) 以及其对应的证明
   - build: tree-sitter 库使用的 Java 语言文法
   - mxeval: 第三方库，包含了检测mbjp数据集中生成的程序是否合法的函数，可通过 `pip install -e mxeval`安装
   - mbjp.json: MBJP完整数据集
6. coqpyt: 和coq交互的第三方库(可以通过`python -m pip install -e coqpyt`安装)
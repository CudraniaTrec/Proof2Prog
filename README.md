## 环境
1. The Coq Proof Assistant, version 8.18.0
   compiled with OCaml 4.14.0
2. python3.8.18
   (tree-sitter                0.20.4
    tree-sitter-languages      1.10.2)
    
## 文档结构
1. TODO.md: 项目进展
2. Makefile: 自动编译 Coq 文件
3. _CoqProject: Coq 项目结构，Makefile 的依赖
4. demo: Coq 代码
   - Syntax.v: Coq 定义的语法以及类型分析
   - test.v: 测试一个证明能够被接受
5. src: java代码到 Coq 证明的翻译
   - program_model.py: 内存形式的程序模型
   - utils.py: 翻译 Java 程序到内存形式的程序
   - run.ipynb: 实际运行整个翻译流程
   - solutions: 所有的 Java 程序
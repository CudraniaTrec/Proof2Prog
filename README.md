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
   - Maps.v: SF里面包含 Map 定义的章节
   - test.v: 测试一个证明能够被接受
5. translation: java代码到 Coq 证明的翻译
   - program_model.py: 内存形式的 java程序/Coq证明 模型
   - utils.py: 翻译 Java 程序到内存形式的程序
   - run_translation.ipynb: 实际运行 java程序->coq证明 的翻译流程
   - run_tokenization.ipynb: 实现 Coq 证明的序列化
   - run_detokenization.ipynb: 实现 Coq 证明的反序列化
   - solutions: 所有的 Java 程序(leetcode benchmark)
   - mbjp: 所有的 Java 程序(mbjp benchmark) 
     - MBJP_xx.java: java 程序
     - MBJP_xx.v: 对应的 Coq 证明
     - MBJP_xx.pkl: 对应的序列化的证明
   - build: tree-sitter 库使用的 Java 语言文法
   - mxeval: 第三方库，包含了检测mbjp数据集中生成的程序是否合法的函数，可通过 `pip install -e mxeval`安装
   - mbjp.json: MBJP完整数据集
   - Data: 其他可能有用的数据
     - GrammarT5_rules.pkl: GrammarT5 使用的词表
     - ruleDict:添加本数据集tokens的词表
     - Tokenizer_vocab: 分词器最终的词表
     - tokenizer.pkl: 分词器
6. coqpyt: 和coq交互的第三方库(可以通过`python -m pip install -e coqpyt`安装)
---
title: sublime使用
date: 2015/9/9
categories:
- tools
tags:
- sublime使用
---

### 安装插件 package control
ctrl + p -- in  
ctrl + shift + p -- 命令面板（Command Palette）  

ctrl + shift + t -- cmd  


### 增强侧边栏
https://github.com/titoBouzout/SideBarEnhancements/tree/st3

### markdown 样式
sublime-monokai-extended
https://github.com/jonschlinkert/sublime-monokai-extended

### markdown gfm配置
```json
{
    //"color_scheme": "Packages/MarkdownEditing/MarkdownEditor.tmTheme",
    "color_scheme": "Packages/MarkdownEditing/MarkdownEditor-Yellow.tmTheme",
    "highlight_line": true, // 高亮正在编辑的行
    "line_numbers": true,   // 显示行号
    "tab_size": 4,          // tab宽度
    "translate_tabs_to_spaces": true,   // tab转换为空格
    //"trim_trailing_white_space_on_save": true,  // 保存时去掉行尾空格
    "word_wrap": true,      // 自动换行
    "wrap_width": "auto",    // 换行的宽度,默认80会造成左侧大量留白
    //"mde.keep_centered": true,  // 可以保持你正在编辑的行始终处于屏幕的中间
    "draw_centered": false, // 改为false，原始值为true
    "wrap_width": 110, // 每行字符数上限
}
```

package com.lucasbarros.view;

import java.util.List;

public class Block {
    final List<String> lines;
    final int width;
    final int rootCol;

     Block(List<String> lines, int width, int rootCol) {
        this.lines = lines;
        this.width = width;
        this.rootCol = rootCol;
    }
}

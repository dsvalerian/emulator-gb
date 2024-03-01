package com.github.dsvalerian.emu.gb.cpu

data class Instruction(
    val opFunction: () -> Boolean,
    val cycles: Int,
    val extraCycles: Int
)
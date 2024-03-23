package com.github.dsvalerian.emu.gb.cpu

data class Instruction(
    val opFunction: () -> Boolean,
    val cycles: Int,
    val extraCycles: Int) {
    constructor(opFunction: () -> Boolean, cycles: Int): this(opFunction, cycles, 0)
}
package com.github.dsvalerian.emu.gb.cpu

import com.github.dsvalerian.emu.gb.Bus

class Cpu(private val bus: Bus) {
    val registers: Registers = Registers()

    private val instructions: InstructionPool = InstructionPool(this)

    private var opCode: UByte = 0x0000u
    private var cycles: Int = 0

    fun read(address: UShort): UByte = bus.read(address)

    fun write(address: UShort, data: UByte) {
        bus.write(address, data)
    }

    fun clock() {
        if (cycles == 0) {
            // Read instruction.
            opCode = read(registers.pc)
            registers.pc++
            val instruction: Instruction = instructions.lookup[opCode.toInt()]

            // Execute instruction.
            val addExtraCycles: Boolean = instruction.opFunction.invoke()
            cycles = if (addExtraCycles) instruction.cycles + instruction.extraCycles else instruction.cycles
        }

        cycles--;
    }
}
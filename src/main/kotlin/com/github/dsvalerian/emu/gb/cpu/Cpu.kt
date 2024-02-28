package com.github.dsvalerian.emu.gb.cpu

import com.github.dsvalerian.emu.gb.Bus

class Cpu(private val bus: Bus) {
    private val registers: Registers = Registers()

    fun write(address: UShort, data: UByte) {
        bus.write(address, data)
    }

    fun read(address: UShort): UByte {
        return bus.read(address)
    }
}
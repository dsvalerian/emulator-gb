package com.github.dsvalerian.emu.gb

class Bus {
    private val memory: UByteArray = UByteArray(0x10000)

    fun read(address: UShort): UByte = memory[address.toInt()]

    fun write(address: UShort, data: UByte) {
        memory[address.toInt()] = data
    }
}
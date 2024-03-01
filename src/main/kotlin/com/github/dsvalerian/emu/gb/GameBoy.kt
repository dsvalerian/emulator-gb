package com.github.dsvalerian.emu.gb

import com.github.dsvalerian.emu.gb.cpu.Cpu

class GameBoy {
    private val bus: Bus = Bus()
    private val cpu: Cpu = Cpu(bus)

    fun start() {
        // todo
    }
}
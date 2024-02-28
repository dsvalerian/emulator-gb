package com.github.dsvalerian.emu.gb

import com.github.dsvalerian.emu.gb.cpu.Cpu

class GameBoy {
    init {
        val bus = Bus()
        val cpu = Cpu(bus)
    }
}
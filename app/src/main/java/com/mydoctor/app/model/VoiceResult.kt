package com.mydoctor.app.model

import java.io.Serializable

class VoiceResult(val textResult: String, val pathToAudioFile: String) : Serializable {
}
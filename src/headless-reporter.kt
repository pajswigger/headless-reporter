package burp

import java.io.File


class BurpExtender: IBurpExtender {
    override fun registerExtenderCallbacks(callbacks: IBurpExtenderCallbacks) {
        for (arg in callbacks.commandLineArguments) {
            if (arg.startsWith("--report")) {
                val fileName = arg.substringAfter('=')
                callbacks.generateScanReport(fileName.substringAfter('.').toUpperCase(), callbacks.getScanIssues(""), File(fileName))
                callbacks.exitSuite(false)
            }
        }
    }
}

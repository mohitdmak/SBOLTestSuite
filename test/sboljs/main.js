
var SBOLDocument = require('sboljs')
var glob = require('glob')
var colors = require('colors')

var valid = glob.sync('valid/**/*.rdf')
var invalid = glob.sync('invalid/**/*.rdf')

var n = 0

process.on('uncaughtException', function(err) {
  console.log((prefix() + 'Library exception: ' + err).yellow)
  checkNextInvalid()
})

console.log('Checking ' + valid.length + ' valid file(s) and ' + invalid.length + ' invalid file(s)')
checkNextInvalid()



function prefix() {
    return '[' + (n + 1) + '/' + invalid.length + '] '
}

function checkNextInvalid() {

    var filename = invalid[n ++]

    var done = false

    SBOLDocument.loadRDFFile(filename, (err, sbol) => {

        if(done)
            return

        done = true

        if(err) {
            console.log(
                (prefix() + err).green
            )
        } else {
            console.log(
                (prefix() + 'Test ' + filename + ' loaded successfully but shouldn\'t have').red
            )
        }

        if(n < invalid.length - 1)
            checkNextInvalid()
    })


}






# clj-customerio

Quickly upload csv files to customer.io.

## Usage

The first row of the csv file must contain headers. A minimal valid csv file would be:

    id,email
    1,chris@untrod.com

The order of columns does not matter. Fields must be separated by commas only (no spaces) and lines separated with either \n or \r\n. Any fields beyond email and id are treated as additional properties to be sent to customer.io. If the id is already present in customer.io, the record will be updated. Otherwise it will be created.

Run with leiningrad, with the following arguments:

    $ lein run -f <csv file path> -u <site id> -p <api key>

## License

The MIT License (MIT)

Copyright (c) 2014 Christopher Clark

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

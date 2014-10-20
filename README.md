# clj-customerio

Quickly upload csv files to customer.io.

## Usage

The first row of the csv file must contain headers. A minimal valid csv file would be:

    id,email
    1,chris@untrod.com

The order of columns does not matter. Fields must be separated by commas (or comma-space) and lines separated with either \n or \r\n. Any fields beyond email and id are treated as additional properties to be sent to customer.io. If the id is already present in customer.io, the record will be updated. Otherwise it will be created.

Run with leiningrad, with the following arguments:

    $ lein run -f <csv file path> -u <site id> -p <api key>

## License

MIT. See LICENSE file.

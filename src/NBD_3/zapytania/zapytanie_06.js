db.people.insertOne({
    "birth_date": ISODate("1997-11-11"),
    "credit": {
        "balance": 333.00,
        "currency": "EUR",
        "number": "6452625362546254",
        "type": "visa"
    },
    "description": "bacon ipsum salad",
    "email": "s15045@pjwstk.edu.pl",
    "first_name": "Grzegorz",
    "height": 180.0,
    "job": "Employed",
    "last_name": "Gołębiowski",
    "location": {
        "address": {
            "streetname": "Sezamowa",
            "streetnumber": "12"
        },
        "city": "Warsaw",
    },
    "nationality": "Poland",
    "sex": "Male",
    "weight": 100.00
})
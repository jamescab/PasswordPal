const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const cardSchema = new Schema({
    app: {
        type: String,
        required: true
    },
    user: {
        type: String,
        required: true
    }, 
    pass: {
        type: String,
        required: true
    }
}, {timestamps: true});

const Card = mongoose.model('Card', cardSchema);
module.exports = Card;
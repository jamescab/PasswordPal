const express = require('express');
const morgan = require('morgan');
const mongoose = require('mongoose');
const { render } = require('ejs');
const walletRoutes = require('./routes/walletRoutes');

/*
TODO:
- Homepage:
  - user login
*/

//Express app
const app = express();

//Connect to mongodb (NEVER LEAVE SIGN IN INFO IN CODE WHEN UR DONE)  
const dbURI = 'mongodb+srv://<username>:<password>@ppcluster.rgt9i9i.mongodb.net/<collection>?retryWrites=true&w=majority';
mongoose.connect(dbURI, {useNewUrlParser: true, useUnifiedTopology: true})
    .then((result) => app.listen(3000))
    .catch((err) => console.log(err));

//Register view engine
app.set('view engine', 'ejs');

//Middleware and Static Files
app.use(express.static('public'));
app.use(express.urlencoded({extended: true}));
app.use(morgan('dev'));
app.use((req, res, next) => {
    res.locals.path = req.path;
    next();
  });

//ROUTES
app.get('/', (req, res) => {
    res.render('index', {title: 'Home'});
  });

//GET add card to wallet page
app.get('/add', (req, res) => {
  res.render('add', { title: 'Add' });
});

//Wallet Routes
app.use('/wallet', walletRoutes);

// 404 page
app.use((req, res) => {
    res.status(404).render('404', { title: '404' });
});
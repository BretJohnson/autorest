/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.12.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

'use strict';

var models = require('./index');

var util = require('util');

/**
 * @class
 * Initializes a new instance of the StorageAccountListResult class.
 * @constructor
 * The list storage accounts operation response.
 * @member {array} [value] Gets the list of storage accounts and their
 * properties.
 * 
 * @member {string} [nextLink] Gets the link to the next set of results.
 * Currently this will always be empty as the API does not support pagination.
 * 
 */
function StorageAccountListResult(parameters) {
  if (parameters !== null && parameters !== undefined) {
    if (parameters.value) {
      var tempParametersvalue = [];
      parameters.value.forEach(function(element) {
        if (element) {
          element = new models['StorageAccount'](element);
        }
        tempParametersvalue.push(element);
      });
      this.value = tempParametersvalue;
    }
    if (parameters.nextLink !== undefined) {
      this.nextLink = parameters.nextLink;
    }
  }    
}


/**
 * Validate the payload against the StorageAccountListResult schema
 *
 * @param {JSON} payload
 *
 */
StorageAccountListResult.prototype.serialize = function () {
  var payload = {};
  if (util.isArray(this['value'])) {
    payload['value'] = [];
    for (var i = 0; i < this['value'].length; i++) {
      if (this['value'][i]) {
        if (payload['value'] === null || payload['value'] === undefined) {
          payload['value'] = {};
        }
        payload['value'][i] = this['value'][i].serialize();
      }
    }
  }

  if (this['nextLink'] !== null && this['nextLink'] !== undefined) {
    if (typeof this['nextLink'].valueOf() !== 'string') {
      throw new Error('this[\'nextLink\'] must be of type string.');
    }
    payload['nextLink'] = this['nextLink'];
  }

  return payload;
};

/**
 * Deserialize the instance to StorageAccountListResult schema
 *
 * @param {JSON} instance
 *
 */
StorageAccountListResult.prototype.deserialize = function (instance) {
  if (instance) {
    if (instance['value']) {
      var tempInstancevalue = [];
      instance['value'].forEach(function(element1) {
        if (element1) {
          element1 = new models['StorageAccount']().deserialize(element1);
        }
        tempInstancevalue.push(element1);
      });
      this['value'] = tempInstancevalue;
    }

    if (instance['nextLink'] !== undefined) {
      this['nextLink'] = instance['nextLink'];
    }
  }

  return this;
};

module.exports = StorageAccountListResult;

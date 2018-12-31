'use strict';
const Generator = require('yeoman-generator');
const chalk = require('chalk');
const yosay = require('yosay');

module.exports = class extends Generator {
  prompting() {
    // Have Yeoman greet the user.
    this.log(
      yosay(`Welcome to the geometric ${chalk.red('generator-springboot-rest')} generator!`)
    );

    const prompts = [
      {
        type: 'input',
        name: 'groupId',
        message: 'What is the groupId?'
      },
      {
        type: 'input',
        name: 'artifactId',
        message: 'What is the artifactId?'
      }
    ];

    return this.prompt(prompts).then(props => {
      // To access props later use this.props.someAnswer;
      this.props = props;
    });
  }

  scaffoldFolders () {
  }

  writing() {
    this.fs.copyTpl(
      this.templatePath('project-structure'),
      this.destinationPath('./' + this.props.artifactId), {
        artifactId: this.props.artifactId,
        groupId: this.props.groupId
      }
    );
  }

  
};

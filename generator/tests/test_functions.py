#!/usr/bin/env python

import os
import shutil
import sys 
sys.path.append(os.path.dirname(os.path.abspath(__file__)) + '/..')
from util import global_variables

# See string differences
import difflib



path_to_tests = ''
function_table = {'binding': 'run_bindings_tests',
                  'cmake': 'run_cmake_tests',
                  'cpp': 'run_cpp_tests',
                  'java': 'run_java_tests',
                  'exit': 'run_exit_tests',
                  'tex': 'run_tex_tests'}


# set up
def set_path_to_tests(dirname):
    global path_to_tests
    path_to_tests = dirname
    remove_temp()
    set_running_tests()


# set running tests variable
# needs to be separate as the global run test function uses it
def set_running_tests():
    global_variables.running_tests = True
    global_variables.code_returned = global_variables.return_codes['success']


# get the xml filename
# and print a banner defining the test
def set_up_test(name, class_name, test_case=''):
    set_running_tests()
    print('====================================================')
    print('Testing {0}:{1} {2}'.format(name, class_name, test_case))
    print('====================================================')
    fname = '{0}.xml'.format(name)
    filename = os.path.join(path_to_tests, 'test_xml_files', fname)
    return filename


# reads file containing expected sbml model and returns it as string
def read_file(path):
    filein = open(path, 'r')
    contents = filein.read()
    filein.close()
    return contents


def see_difference(data1, data2, show_data = False):
    if show_data is False:
        return
    # differences = difflib.ndiff(data1, data2)
    # for i, s in enumerate(differences):
    #     print(i,s)
    # d = difflib.Differ()
    # diff = d.compare(data1, data2)
    # print('\n'.join(diff))
    # diff = difflib.unified_diff(data1, data2, lineterm='\n')
    # # diff = difflib.SequenceMatcher(None, data1, data2)
    # print('\n'.join(list(diff)))

    # diff = difflib.ndiff(data1.splitlines(1), data2.splitlines(1))
    # d = difflib.Differ()
    # diff = d.compare(data1.splitlines(1), data2.splitlines(1))
    # print('\n'.join(list(diff)))
    print('---------------------Showing Differences---------------------')
    diff = difflib.unified_diff(data1.splitlines(1), data2.splitlines(1))
    print('\n'.join(list(diff)))
    print('====================================================')
    print('\n')


# do a string comparison of the contents of two file
def compare_files(infile, outfile, fails, not_tested):
    ret = 0
    if not os.path.isfile(infile):
        # we have not added a file to compare to
        not_tested.append(infile)
        return ret
    elif not os.path.isfile(outfile):
        print(outfile)
        fails.append(infile)
        print('{0}=================>> MISSING'.format(outfile))
        return 1
    indata = read_file(infile)
    out = read_file(outfile)
    if indata.strip() == out.strip():
        print('{0} .... PASSED'.format(outfile))
    else:
        fails.append(infile)
        see_difference(indata, out, show_data=True)
        print('{0}=================>> FAILED'.format(outfile))
        ret = 1
    return ret





def compare_return_codes(name, flag, expected_return, fails):
    ret = 0
    this_return = global_variables.code_returned
    expected = global_variables.get_return_code(expected_return)
    if this_return == expected_return:
        print('{0} returned \'{1}\' as expected'.format(name, expected))
    else:
        ret = 1
        fails.append('{0}: {1} {2}'.format(name, flag, expected_return))
        print('Incorrect Return: {0} Expected: '
              '{1}'.format(global_variables.get_return_code(this_return),
                           global_variables.get_return_code(expected_return)))
    return ret


# run a set of tests
def run_tests(test_name, name, fails):
    ret = 0
    print('====================================================')
    print('Running {0}'.format(test_name))
    print('====================================================')
    module = '{0}.{1}.main()'.format(test_name, function_table[name])
    # I have a circular dependency in my imports if I declare these globally
    # see http://stackoverflow.com/questions/9252543/importerror-cannot-import-name-x
    import test_binding_code
    import test_cmake_code
    import test_cpp_code
    import test_java_code
    import test_exit_codes
    import test_tex_files
    fail = eval(module)
    if fail > 0:
        ret = 1
        fails.append(name)
        print('{0}=================>> FAILED'.format(test_name))
    else:
        print('{0} .... PASSED'.format(test_name))
    print('')
    return ret


# write a report for the tests
def report(name, fail, fails, not_tested):
    print('****************************************************************')
    print('REPORT for {0} Tests'.format(name))

    if len(not_tested) > 0:
        print('The following files were not tested:')
        for name in not_tested:
            print(name)
    else:
        print('All tests were run.')

    if fail > 0:
        print('!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!')
        print('{0} fails reported:'.format(fail))
        for name in fails:
            print(name)
    else:
        print('No fails reported.')
    print('****************************************************************')
    print('')


def remove_temp():
    if not os.path.isdir('temp'):
        os.mkdir('temp')
    else:
        shutil.rmtree('temp')
        os.mkdir('temp')